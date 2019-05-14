package com.test.kotlin.domain.interactor

import com.test.kotlin.data.repository.main.MainRepository
import com.test.kotlin.domain.base.UseCase
import com.test.kotlin.mvp.model.entity.State
import io.reactivex.Single

class GetStateListInteractor(private val mMainRepository: MainRepository) : UseCase.RxSingle<List<State>>() {

    override fun build(): Single<List<State>> = mMainRepository.getInfo()

}