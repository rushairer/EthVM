<template>
  <v-container pa-0>
    <v-layout d-block>
      <!--
      =====================================================================================
        Mobile (XS)
      =====================================================================================
      -->
      <v-flex xs12 hidden-sm-and-up>
        <div class="table-row-mobile">
          <v-layout grid-list-xs row wrap align-center justify-start fill-height class="pt-3 pb-3 pr-4 pl-4">
            <v-flex xs6 pa-1>
              <router-link class="black--text font-weight-medium pb-1" :to="`/block/number/${block.number}`"
                >{{ $t('block.number') }} {{ block.numberFormatted }}</router-link
              >
            </v-flex>
            <v-flex xs6 pr-44>
              <v-layout row justify-end>
                <p>
                  {{ block.numSuccessfulTxsFormatted.value }} {{ $tc('tx.name-short', sucessTransalate()) }}
                  <app-tooltip v-if="block.numSuccessfulTxsFormatted.tooltipText" :text="block.numSuccessfulTxsFormatted.tooltipText" />
                </p>
                <p v-if="block.numFailedTxsBN > 0" class="txFail--text pl-1">
                  ({{ block.numFailedTxsFormatted.value }} {{ $tc('tx.failed', failedTranslate()) }}
                  <app-tooltip v-if="block.numFailedTxsFormatted.tooltipText" :text="block.numFailedTxsFormatted.tooltipText" />)
                </p>
              </v-layout>
            </v-flex>
            <v-flex xs2 pa-1>
              <p class="info--text psmall">{{ $t('common.hash') }}:</p>
            </v-flex>
            <v-flex xs10 pa-1>
              <app-transform-hash :hash="block.hash" :link="`/block/hash/${block.hash}`" />
            </v-flex>
            <v-flex xs2 pa-1>
              <p class="info--text psmall pr-1">{{ $t('miner.name') }}:</p>
            </v-flex>
            <v-flex xs10 pa-1>
              <app-transform-hash :hash="block.author" :italic="true" :link="`/address/${block.author}`" />
            </v-flex>
            <v-flex xs2 pa-1>
              <p class="info--text psmall">{{ $t('miner.reward-short') }}:</p>
            </v-flex>
            <v-flex xs10 pa-1>
              <p class="black--text align-center pl-2">
                {{ block.rewardFormatted.value }}
                <app-tooltip v-if="block.rewardFormatted.tooltipText" :text="block.rewardFormatted.tooltipText" />
              </p>
            </v-flex>
          </v-layout>
        </div>
      </v-flex>
      <!--
      =====================================================================================
        Tablet/ Desktop (SM - XL)
      =====================================================================================
      -->
      <v-flex hidden-xs-only sm12>
        <!--
        =====================================================================================
          Block Info
        =====================================================================================
        -->
        <v-layout grid-list-xs row wrap align-center justify-start fill-height pl-3 pr-2 pt-2 pb-1>
          <v-flex sm2>
            <router-link class="black--text pb-1" :to="`/block/number/${block.number}`">{{ block.numberFormatted }}</router-link>
            <div v-if="block.uncleHashes.length" class="arrow">
              <div class="line"></div>
            </div>
          </v-flex>
          <v-flex sm6>
            <v-layout row pb-2>
              <p class="info--text psmall pr-2">{{ $t('common.hash') }}:</p>
              <app-transform-hash :hash="block.hash" :link="`/block/hash/${block.hash}`" />
            </v-layout>
            <v-layout row>
              <p class="info--text pr-1">{{ $t('miner.name') }}:</p>
              <app-transform-hash :hash="block.author" :italic="true" :link="`/address/${block.author}`" />
            </v-layout>
          </v-flex>
          <v-spacer hidden-xl-only />
          <v-flex sm2>
            <v-layout row wrap>
              <p class="pr-1">
                {{ block.numSuccessfulTxsFormatted.value }} {{ $tc('tx.name-short', sucessTransalate()) }}
                <app-tooltip v-if="block.numSuccessfulTxsFormatted.tooltipText" :text="block.numSuccessfulTxsFormatted.tooltipText" />
              </p>
              <p v-if="block.numFailedTxsBN > 0" class="txFail--text">
                ({{ block.numFailedTxsFormatted.value }} {{ $tc('tx.failed', failedTranslate()) }}
                <app-tooltip v-if="block.numFailedTxsFormatted.tooltipText" :text="block.numFailedTxsFormatted.tooltipText" />)
              </p>
            </v-layout>
          </v-flex>
          <v-flex sm1 xl2>
            <p class="black--text align-center mb-0">
              {{ block.rewardFormatted.value }}
              <app-tooltip v-if="block.rewardFormatted.tooltipText" :text="block.rewardFormatted.tooltipText" />
            </p>
          </v-flex>
        </v-layout>
        <!--
        =====================================================================================
          Uncles Info
        =====================================================================================
        -->
        <v-flex sm12 v-if="block.uncleHashes.length" pt-3>
          <v-layout row class="uncle">
            <v-flex sm2></v-flex>
            <v-flex sm6>
              <div class="uncles">
                <v-card flat color="transparent">
                  <v-card-title class="pt-1 font-weight-medium pb-2">{{ $tc('uncle.name', 2) }}:</v-card-title>
                  <v-layout row pl-4 pr-4 pb-2 v-for="(uncle, index) in block.uncleHashes" :key="index">
                    <p class="info--text psmall pr-2">{{ $t('common.hash') }}:</p>
                    <app-transform-hash :hash="uncle" :link="`/uncle/${uncle}`" />
                  </v-layout>
                </v-card>
              </div>
            </v-flex>
            <v-spacer />
          </v-layout>
        </v-flex>
        <v-divider class="mb-2 mt-2" />
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script lang="ts">
import { Component, Prop, Mixins } from 'vue-property-decorator'
import AppTransformHash from '@app/core/components/ui/AppTransformHash.vue'
import { BlockSummaryPageExt_items } from '@app/core/api/apollo/extensions/block-summary-page.ext'
import { NumberFormatMixin } from '@app/core/components/mixins/number-format.mixin'
import AppTooltip from '@app/core/components/ui/AppTooltip.vue'

@Component({
  components: {
    AppTooltip,
    AppTransformHash
  }
})
export default class TableBlocksRow extends Mixins(NumberFormatMixin) {
  /*
  ===================================================================================
    Props
  ===================================================================================
  */

  @Prop({ type: String, default: 'home' }) pageType!: string
  @Prop(Object) block!: BlockSummaryPageExt_items

  /*
  ===================================================================================
    Methods
  ===================================================================================
  */

  sucessTransalate(): number {
    return this.block && this.block.numSuccessfulTxsBN!.toNumber() > 1 ? 2 : 1
  }

  failedTranslate(): number {
    return this.block && this.block.numFailedTxsBN!.toNumber() > 1 ? 2 : 1
  }
}
</script>

<style scoped lang="css">
.table-row-mobile {
  border: 1px solid #b4bfd2;
}

p {
  margin-bottom: 0px;
  padding-bottom: 0px;
}
.arrow {
  position: relative;
}

.line {
  border-left: 1px solid #b4bfd2;
  border-bottom: 1px solid #b4bfd2;
  height: 50px;
  width: 105%;
  position: absolute;
  margin-left: 2px;
  margin-bottom: 10px;
}

.uncles {
  border: 1px solid #b4bfd2;
  padding-bottom: 5px;
}
</style>
