package com.cyclone.solana.core.datamodel.dto.crypto

import androidx.annotation.Keep
import com.cyclone.solana.core.constants.SystemProgram
import com.cyclone.solana.core.extensions.toLEByteArray
import com.cyclone.solana.core.datamodel.interfaces.crypto.InstructionData
import com.cyclone.solana.core.usecase.CompactArrayEncoder

@Keep
data class SolTransferInstructionData(private val lamports: Long): InstructionData {
    override fun serialise(): ByteArray {
        val functionIndexBytes = SystemProgram.Enums.TRANSFER
            .toLEByteArray(4) /* u32 */

        val lamportsBytes = lamports
            .toLEByteArray(8) /* u64 */

        val size = functionIndexBytes.size + lamportsBytes.size

        val compactU16 = CompactArrayEncoder.invoke(
            size
        )

        return compactU16 +
                functionIndexBytes +
                lamportsBytes
    }
}
