package com.cyclone.solana.core.repository.interfaces

import com.cyclone.solana.core.datamodel.dto.solanaRPC.RPCResponse
import com.cyclone.solana.core.network.NetworkResource
import kotlinx.coroutines.flow.Flow

interface SolanaRPCRepository {
    suspend fun getBalance(address: String): Flow<NetworkResource<RPCResponse.SuccessResponse, RPCResponse.ErrorResponse>>
    suspend fun getLatestBlockHash(): Flow<NetworkResource<RPCResponse.SuccessResponse, RPCResponse.ErrorResponse>>
    suspend fun sendTransaction(vararg transaction: String): Flow<NetworkResource<RPCResponse.SuccessResponse, RPCResponse.ErrorResponse>>
    suspend fun getTransaction(transactionSignature: String, commitment: String): Flow<NetworkResource<RPCResponse.SuccessResponse, RPCResponse.ErrorResponse>>
}