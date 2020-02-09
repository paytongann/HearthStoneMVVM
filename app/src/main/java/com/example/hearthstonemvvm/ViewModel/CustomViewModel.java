package com.example.hearthstonemvvm.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.hearthstonemvvm.Model.ApiInterface;
import com.example.hearthstonemvvm.Model.ResultsPojo;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
    }
}
