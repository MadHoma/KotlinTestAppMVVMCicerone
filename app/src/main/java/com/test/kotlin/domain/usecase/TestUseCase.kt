package com.test.kotlin.domain.usecase

import io.reactivex.Single
import com.test.kotlin.data.repository.MainRepository
import com.test.kotlin.domain.base.UseCase
import com.test.kotlin.presentation.base.model.BaseModel

class TestUseCase(private val mMainRepository: MainRepository) : UseCase.RxSingle<BaseModel>() {

    override fun build(): Single<BaseModel> = mMainRepository.getInfo()

}