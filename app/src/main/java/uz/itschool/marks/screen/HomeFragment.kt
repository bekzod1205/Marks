package uz.itschool.marks.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.itschool.marks.R
import uz.itschool.marks.databinding.FragmentHomeBinding
import uz.itschool.marks.util.ShPHelper

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        val a = ShPHelper.getInstance(requireContext()).getUser()!!
        if (a[1] == "0") {
            parentFragmentManager.beginTransaction()
                .replace(R.id.home_container, StudentFragment.newInstanceSt(a[0].toInt())).commit()
        } else if (a[1] == "1") {
            childFragmentManager.beginTransaction()
                .add(R.id.home_container, TeacherFragment.newInstance(a[0].toInt())).commit()
        }
        return binding.root
    }
}