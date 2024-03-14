package br.leeloo.coinpaprika.core.data.remote.network

interface HttpClient {
    fun <T> create(clazz: Class<T>): T
}