package com.example.android_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class InputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_input, container, false)

        val spinnerBooks: Spinner = view.findViewById(R.id.spinnerBooks)
        val radioGroupYears: RadioGroup = view.findViewById(R.id.radioGroupYears)
        val buttonOk: Button = view.findViewById(R.id.buttonOk)


        val books = arrayOf("Володар перснів", "Гаррі Поттер", "Маг", "Нічна Варта")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, books)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerBooks.adapter = adapter

        buttonOk.setOnClickListener {
            val selectedBook = spinnerBooks.selectedItem.toString()
            val selectedYearId = radioGroupYears.checkedRadioButtonId

            if (selectedYearId == -1) {
                Toast.makeText(requireContext(), "Оберіть рік!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedYear = view.findViewById<RadioButton>(selectedYearId).text.toString()

            (activity as MainActivity).showResultFragment(selectedBook, selectedYear)
        }

        return view
    }
}