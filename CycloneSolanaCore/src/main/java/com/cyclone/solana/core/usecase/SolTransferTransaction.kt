package com.cyclone.solana.core.usecase

import com.cyclone.solana.core.constants.Address
import com.cyclone.solana.core.constants.SystemProgram
import com.cyclone.solana.core.datamodel.dto.crypto.*

object SolTransferTransaction {
    operator fun invoke(
        fromAddress: String,
        toAddress: String,
        blockhash: String,
        lamports: Long
    ): Transaction {
        val header = Header(
            noSigs = 1,
            noSignedReadOnlyAccounts = 0,
            noUnsignedReadOnlyAccounts = 1
        )

        val instruction = TransferInstruction(
            programIdIndex = 2,
            accountIndices = listOf(0, 1),
            data = SolTransferInstructionData(lamports = lamports)
        )

        val message = Message(
            header = header,
            accountAddresses = listOf(
                fromAddress,
                toAddress,
                Address.ProgramAddresses.SYSTEM_PROGRAM,
            ),
            blockhash = blockhash,
            instructions = listOf(instruction)
        )

        return Transaction(
            message = message
        )
    }
}