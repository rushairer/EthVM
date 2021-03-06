import {Trace} from '@app/graphql/schema'
import {assignClean} from '@app/shared/utils'
import {TraceEntity} from '@app/orm/entities/trace.entity'

export class TxTraceDto implements Trace {

  blockHash!: string
  transactionHash?: string
  rootError?: string
  traces!: string

  constructor(data: TraceEntity) {
    assignClean(this, data)
  }
}
