package de.rki.coronawarnapp.ui.submission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityEvent
import de.rki.coronawarnapp.databinding.FragmentSubmissionIntroBinding
import de.rki.coronawarnapp.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_submission_intro.*


/**
 * The [SubmissionIntroFragment] displays information about how the corona warning system works
 */
class SubmissionIntroFragment : BaseFragment() {

    private var _binding: FragmentSubmissionIntroBinding? = null
    private val binding: FragmentSubmissionIntroBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // get the binding reference by inflating it with the current layout
        _binding = FragmentSubmissionIntroBinding.inflate(inflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButtonOnClickListener()
    }

    override fun onStart() {
        super.onStart()
        submission_intro_scrollview.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED)
    }

    override fun onResume() {
        super.onResume()
        submission_intro_scrollview.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED)
    }

    private fun setButtonOnClickListener() {
        binding.submissionIntroHeader.headerButtonBack.buttonIcon.setOnClickListener {
            doNavigate(SubmissionIntroFragmentDirections.actionSubmissionIntroFragmentToMainFragment())
        }
        binding.submissionIntroButtonNext.setOnClickListener {
            doNavigate(SubmissionIntroFragmentDirections.actionSubmissionIntroFragmentToSubmissionDispatcherFragment())
        }
    }
}
