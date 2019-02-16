import { toTx, toSimpleTx } from '@app/server/modules/txs'
import { toUncle } from '@app/server/modules/uncles'
import { Block } from 'ethvm-common'

const toBlock = (block: any, format: string = 'full'): Block => {
  switch (format) {
    case 'full':
      return toFullBlock(block)
    case 'simple':
      return toSimpleBlock(block)
    default:
      throw new Error('Illegal format passed to mapper!')
  }
}

const toReward = (r: any): any => {
  r.reward = r.reward.toString()
  return r
}

const toFullBlock = (block: any): Block => {
  block.header.number = block.header.number.toString()
  block.header.difficulty = block.header.difficulty.toString()
  block.header.gasLimit = block.header.gasLimit.toString()
  block.header.gasUsed = block.header.gasUsed.toString()
  block.totalDifficulty = block.totalDifficulty.toString()

  if (block.rewards) {
    block.rewards.map(r => toReward(r))
  }

  if (block.transactions) {
    block.transactions = block.transactions.map(tx => toTx(tx))
  }

  if (block.uncles) {
    block.uncles = block.uncles.map(u => toUncle(u))
  }

  return block
}

const toSimpleBlock = (block: any): Block => {
  block.header.number = block.header.number.toString()

  if (block.rewards) {
    block.rewards.map(r => toReward(r))
  }

  if (block.transactions) {
    block.transactions = block.transactions.map(tx => toSimpleTx(tx))
  }

  return block
}

export { toBlock }
