package com.cyclone.solana.core.http.dispatcher

import com.cyclone.solana.core.constants.RPC
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import org.json.JSONObject

object LatestBlockhashDispatcher: MockDispatcher {
    override fun getSuccessResponse(): Dispatcher {
        return object: Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                val body = JSONObject(
                    request.body.readUtf8()
                )

                return when (body.getString("method")) {
                    RPC.RPCMethods.GET_LATEST_BLOCKHASH -> {
                        MockResponse()
                            .setResponseCode(200)
                            .setBody("")
                    }
                    RPC.RPCMethods.GET_BALANCE -> {
                        MockResponse()
                            .setResponseCode(200)
                            .setBody("")
                    }
                    RPC.RPCMethods.SEND_TRANSACTION -> {
                        MockResponse()
                            .setResponseCode(200)
                            .setBody("")
                    }
                    else -> {
                        MockResponse().setResponseCode(200)
                    }
                }
            }
        }
    }

    override fun getErrorResponse(): Dispatcher {
        TODO("getErrorResponse Not Implemented")
    }
}