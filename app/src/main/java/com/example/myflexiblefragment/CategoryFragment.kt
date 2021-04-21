package com.example.myflexiblefragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.commit
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_category.view.*

class CategoryFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDetailCategory:Button = view.findViewById(R.id.btn_detail_category)
        btnDetailCategory.setOnClickListener(this)

    }

    override fun onClick(v: View) {
            if (v.id == R.id.btn_detail_category) {
//                Perpindahan Fragment dengan membawa data
                val mDetailCategoryFragment = DetailCategoryFragment()

//                Mekanisme mengirim data antar fragment dengan Object Bundle
                val mBundle = Bundle()
                mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle")
                mDetailCategoryFragment.arguments = mBundle

//                Mekanisme mengirim dara antar fragment menggunakan Setter dan Getter
                val description = "Kategori ini akan berisi produk-produk lifrstyle"
                mDetailCategoryFragment.description = description

                val mFragmentManager =  fragmentManager
                mFragmentManager?.beginTransaction()?.apply {
                    replace(R.id.frame_container, mDetailCategoryFragment, DetailCategoryFragment::class.java.simpleName)
                    addToBackStack(null)
                    commit()
                }

            }
    }
}
