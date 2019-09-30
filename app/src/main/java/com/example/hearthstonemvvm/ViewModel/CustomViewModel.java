package com.example.hearthstonemvvm.ViewModel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hearthstonemvvm.Model.ApiInterface;
import com.example.hearthstonemvvm.Model.CardPojo;
import com.example.hearthstonemvvm.Model.ResultsPojo;
import com.example.hearthstonemvvm.View.MainActivity;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.view.View.combineMeasuredStates;
import static androidx.constraintlayout.widget.Constraints.TAG;

public class CustomViewModel extends ViewModel {

    private MutableLiveData<ResultsPojo> cardList;

    public LiveData<ResultsPojo> getCards() {
        //Condition if the list is NULL
        if (cardList == null) {
            cardList = new MutableLiveData<>();
            //Loading the data asynchronously from server
            loadCards();
        }
        //Returning the list
        return cardList;
    }

    private void loadCards() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        apiInterface.getCardData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ResultsPojo>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResultsPojo arrayListResponse) {
                cardList.setValue(arrayListResponse);
                Log.d(TAG, "onNext: " + arrayListResponse);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
            }
        });
    }
}
