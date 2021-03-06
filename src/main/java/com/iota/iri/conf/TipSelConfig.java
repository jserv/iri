package com.iota.iri.conf;

/**
 * Configuration for how we perform tip selections. Tip selection is invoked when a client wants to find tips to
 * attach its transactions to. The tips are invoked via random walks that start at a certain point in the tangle.
 * The parameters here affect the length and randomness of this walk.
 */
public interface TipSelConfig extends Config {

    /**
     * Default Value: {@value BaseIotaConfig.Defaults#MAX_DEPTH}
     *
     * @return {@value TipSelConfig.Descriptions#MAX_DEPTH}
     */
    int getMaxDepth();

    /**
     * Default Value: {@value BaseIotaConfig.Defaults#ALPHA}
     *
     * @return {@value TipSelConfig.Descriptions#ALPHA}
     */
    double getAlpha();

    /**
     * Default Value: {@value BaseIotaConfig.Defaults#TIP_SELECTION_TIMEOUT_SEC}
     *
     * @return {@value TipSelConfig.Descriptions#TIP_SELECTION_TIMEOUT_SEC}
     */
    int getTipSelectionTimeoutSec();

    /**
     *  Default Value: {@value BaseIotaConfig.Defaults#BELOW_MAX_DEPTH_TRANSACTION_LIMIT}
     *
     * @return {@value TipSelConfig.Descriptions#BELOW_MAX_DEPTH_TRANSACTION_LIMIT}
     */
    int getBelowMaxDepthTransactionLimit();

    interface Descriptions {

        String MAX_DEPTH = "The maximal number of previous milestones from where you can perform the random walk";
        String ALPHA = "Parameter that defines the randomness of the tip selection. " +
                "Should be a number between 0 to infinity, where 0 is most random and infinity is most deterministic.";
        String TIP_SELECTION_TIMEOUT_SEC = "Defines the maximum number of seconds the tip-selection is allowed to be ongoing. "
                + "If the threshold is exceeded, tip-selection is aborted.";
        String BELOW_MAX_DEPTH_TRANSACTION_LIMIT = "The maximal number of unconfirmed transactions that may be analyzed in " +
                "order to find the latest milestone the transaction that we are stepping on during the walk approves";
    }
}
