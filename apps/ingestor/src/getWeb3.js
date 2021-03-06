import Web3 from 'web3'

export default host => {
  const _web3 = new Web3(
    new Web3.providers.WebsocketProvider(host, {
      clientConfig: {
        maxReceivedMessageSize: 1000 * 1024 * 1024
      }
    })
  )
  _web3.extend({
    property: 'trace',
    methods: [
      {
        name: 'traceBlock',
        call: 'trace_replayBlockTransactions',
        params: 2
      }
    ]
  })
  _web3.extend({
    property: 'trace',
    methods: [
      {
        name: 'traceBlockRaw',
        call: 'trace_block',
        params: 1
      }
    ]
  })
  _web3.extend({
    property: 'debug',
    methods: [
      {
        name: 'traceBlockByNumber',
        call: 'debug_traceBlockByNumber',
        params: 2
      }
    ]
  })
  _web3.extend({
    property: 'debug',
    methods: [
      {
        name: 'traceTransaction',
        call: 'debug_traceTransaction',
        params: 2
      }
    ]
  })
  return _web3
}
