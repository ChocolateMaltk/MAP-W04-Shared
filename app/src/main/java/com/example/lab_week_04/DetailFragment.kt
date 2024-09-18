package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.lab_week_04.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DetailFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var coffeeTitle: TextView
    private lateinit var coffeeDesc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coffeeTitle = view.findViewById(R.id.coffee_title)
        coffeeDesc = view.findViewById(R.id.coffee_desc)

        val coffeeId = arguments?.getInt(ListFragment.COFFEE_ID) ?: R.id.affogato
        setCoffeeData(coffeeId)

        view.findViewById<Button>(R.id.back_button).setOnClickListener {
            Navigation.findNavController(view).navigateUp()
        }
    }


    private fun setCoffeeData(id: Int) {
        when (id) {
            R.id.affogato -> {
                coffeeTitle.text = getString(R.string.affogato_title)
                coffeeDesc.text = getString(R.string.affogato_desc)
            }

            R.id.americano -> {
                coffeeTitle.text = getString(R.string.americano_title)
                coffeeDesc.text = getString(R.string.americano_desc)
            }

            R.id.latte -> {
                coffeeTitle.text = getString(R.string.latte_title)
                coffeeDesc.text = getString(R.string.latte_desc)
            }

            R.id.fizzy_black -> {
                coffeeTitle.text = getString(R.string.fizzy_title)
                coffeeDesc.text = getString(R.string.fizzy_desc)
            }

            R.id.beer_coffee -> {
                coffeeTitle.text = getString(R.string.beerCoffee_title)
                coffeeDesc.text = getString(R.string.beerCoffee_desc)
            }
        }
    }

    companion object {
        private const val COFFEE_ID = "COFFEE_ID"
    }
}
