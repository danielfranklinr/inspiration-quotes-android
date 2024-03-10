package com.dfr.inspirationquotes.presentation.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.dfr.inspirationquotes.databinding.ActivityRandomQuoteBinding;
import com.dfr.inspirationquotes.domain.model.QuoteDTO;
import com.dfr.inspirationquotes.presentation.viewmodel.RandomQuoteViewModel;

import java.util.concurrent.TimeUnit;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;


@AndroidEntryPoint
public class RandomQuoteActivity extends AppCompatActivity {

    private ActivityRandomQuoteBinding binding;
    private RandomQuoteViewModel viewModel;
    private Disposable requestDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRandomQuoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(RandomQuoteViewModel.class);


        binding.btnRandomQuote.setOnClickListener(
                view -> requestRandomQuote()
        );
    }

    private void requestRandomQuote() {
        requestDisposable = viewModel
                .getRandomQuote()
                .repeatWhen(completed -> completed.delay(1, TimeUnit.SECONDS))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleReceivedQuote, this::handleError, this::onComplete);


    }

    private void onComplete() {
        if (!requestDisposable.isDisposed())
            requestDisposable.dispose();
    }

    private void handleReceivedQuote(QuoteDTO quote) {
        binding.quoteText.setText(quote.getQuote());
        binding.quoteAuthor.setText(quote.getAuthor());
    }

    private void handleError(Throwable throwable) {
        Toast.makeText(this
                , "An error occurred trying to get the quote"
                , Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        if (!requestDisposable.isDisposed())
            requestDisposable.dispose();
        super.onStop();
    }
}