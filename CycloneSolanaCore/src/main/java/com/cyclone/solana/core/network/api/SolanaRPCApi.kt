package com.cyclone.solana.core.network.api

import com.cyclone.solana.core.datamodel.dto.solanaRPC.request.RPCRequest
import com.cyclone.solana.core.datamodel.dto.solanaRPC.response.RPCResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class SolanaRPCApi(private val client: HttpClient) {
    suspend fun getBalance(
        body: RPCRequest.RequestGetBalance
    ): RPCResponse.Response = client.post("/") {
        setBody(body)
    }.body()

    suspend fun getLatestBlockhash(
        body: RPCRequest.RequestLatestBlockhash
    ): RPCResponse.Response = client.post("/") {
        setBody(body)
    }.body()

    suspend fun sendTransaction(
        body: RPCRequest.RequestSendTransaction
    ): RPCResponse.Response = client.post("/") {
        setBody(body)
    }.body()

    suspend fun getTransaction(
        body: RPCRequest.RequestGetTransaction
    ): RPCResponse.Response = client.post("/") {
        setBody(body)
    }.body()

    suspend fun getTokenAccountsByOwner(
        body: RPCRequest.RequestGetTokenAccountsByOwner
    ): RPCResponse.Response = client.post("/") {
        setBody(body)
    }.body()

    suspend fun getAccountInfo(
        body: RPCRequest.RequestGetAccountInfo
    ): RPCResponse.Response = client.post("/") {
        setBody(body)
    }.body()
}