package com.saadfauzi.edupajak.data.repository

import com.saadfauzi.edupajak.data.local.PajakDao
import com.saadfauzi.edupajak.data.local.PajakEntity
import javax.inject.Inject

class PajakRepository @Inject constructor(private val pajakDao: PajakDao) {
    fun getAllTaxes() = pajakDao.getAllTaxes()
    fun getAllBookmarkedTaxes() = pajakDao.getAllBookmarkedTaxes()
    fun getTaxes(id: Int) = pajakDao.getTaxes(id)
    fun searchTaxes(query: String) = pajakDao.searchTaxes(query)
    suspend fun insertAllTaxes(taxes: ArrayList<PajakEntity>) = pajakDao.insertAllTaxes(taxes)
    suspend fun updateBookmarkedTaxes(id: Int, isBookmarked: Boolean) = pajakDao.updateBookmarkedTaxes(id, isBookmarked)
}