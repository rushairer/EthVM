/*
 * This file is generated by jOOQ.
 */
package com.ethvm.db.tables;


import com.ethvm.db.Public;
import com.ethvm.db.tables.records.TokenMetadataRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TokenMetadata extends TableImpl<TokenMetadataRecord> {

    private static final long serialVersionUID = -694609644;

    /**
     * The reference instance of <code>public.token_metadata</code>
     */
    public static final TokenMetadata TOKEN_METADATA = new TokenMetadata();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TokenMetadataRecord> getRecordType() {
        return TokenMetadataRecord.class;
    }

    /**
     * The column <code>public.token_metadata.name</code>.
     */
    public final TableField<TokenMetadataRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>public.token_metadata.symbol</code>.
     */
    public final TableField<TokenMetadataRecord, String> SYMBOL = createField("symbol", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>public.token_metadata.address</code>.
     */
    public final TableField<TokenMetadataRecord, String> ADDRESS = createField("address", org.jooq.impl.SQLDataType.CHAR(42), this, "");

    /**
     * The column <code>public.token_metadata.decimals</code>.
     */
    public final TableField<TokenMetadataRecord, Integer> DECIMALS = createField("decimals", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.token_metadata.website</code>.
     */
    public final TableField<TokenMetadataRecord, String> WEBSITE = createField("website", org.jooq.impl.SQLDataType.VARCHAR(256), this, "");

    /**
     * The column <code>public.token_metadata.logo</code>.
     */
    public final TableField<TokenMetadataRecord, String> LOGO = createField("logo", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.token_metadata.support</code>.
     */
    public final TableField<TokenMetadataRecord, String> SUPPORT = createField("support", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.token_metadata.type</code>.
     */
    public final TableField<TokenMetadataRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR(32), this, "");

    /**
     * Create a <code>public.token_metadata</code> table reference
     */
    public TokenMetadata() {
        this(DSL.name("token_metadata"), null);
    }

    /**
     * Create an aliased <code>public.token_metadata</code> table reference
     */
    public TokenMetadata(String alias) {
        this(DSL.name(alias), TOKEN_METADATA);
    }

    /**
     * Create an aliased <code>public.token_metadata</code> table reference
     */
    public TokenMetadata(Name alias) {
        this(alias, TOKEN_METADATA);
    }

    private TokenMetadata(Name alias, Table<TokenMetadataRecord> aliased) {
        this(alias, aliased, null);
    }

    private TokenMetadata(Name alias, Table<TokenMetadataRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> TokenMetadata(Table<O> child, ForeignKey<O, TokenMetadataRecord> key) {
        super(child, key, TOKEN_METADATA);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TokenMetadata as(String alias) {
        return new TokenMetadata(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TokenMetadata as(Name alias) {
        return new TokenMetadata(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TokenMetadata rename(String name) {
        return new TokenMetadata(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TokenMetadata rename(Name name) {
        return new TokenMetadata(name, null);
    }
}
