package br.com.psoa.jackpot.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.psoa.jackpot.Injectable
import br.com.psoa.jackpot.R
import br.com.psoa.jackpot.entity.MegaSenaEntity
import kotlinx.android.synthetic.main.fragment_main.*
import java.text.NumberFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject


class MainFragment : Fragment(), Injectable {

    private lateinit var pageViewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pageViewModel = ViewModelProvider(this, viewModelFactory)
            .get(MainViewModel::class.java)
        pageViewModel.loadLastResult().observe(viewLifecycleOwner, Observer<MegaSenaEntity> {
            lottery.text = it.lottery.toString()
            accumulated.text = (!it.has_winner).toString()
            amount.text = getPrize(it.prize);
            date.text = getLocalDate(it.date)
            numbers.text = it.numbers.joinToString(separator = ", ")
            next_amount.text = getPrize(it.next_amount);
            next_date.text = getLocalDate(it.next_date)
        })
    }

    private fun getPrize(prize: Double)
            : String = NumberFormat
                .getNumberInstance(Locale("pt", "BR")).format(prize)

    private fun getLocalDate(date: String)
            :String =  LocalDate.parse(date,
            DateTimeFormatter.ofPattern("yyyy-MM-dd",
                Locale.getDefault()))
            .format(
                DateTimeFormatter
                    .ofPattern("dd/MM/yyyy")).toString()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(sectionNumber: Int): MainFragment {
            return MainFragment()
        }
    }
}