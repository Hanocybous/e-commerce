-- Table for session management
create table spring_session
(
    primary_id            varchar(36) not null
        constraint spring_session_pk
            primary key,
    session_id            varchar(36) not null,
    creation_time         bigint   not null,
    last_access_time      bigint   not null,
    max_inactive_interval integer  not null,
    expiry_time           bigint   not null,
    principal_name        varchar(100)
);

create unique index spring_session_ix1
    on spring_session (session_id);

create index spring_session_ix2
    on spring_session (expiry_time);

create index spring_session_ix3
    on spring_session (principal_name);

-- Table for session attributes
create table spring_session_attributes
(
    session_primary_id varchar(36) not null,
    attribute_name     varchar(200) not null,
    attribute_bytes    bytea        not null,
    constraint spring_session_attributes_pk
        primary key (session_primary_id, attribute_name)
);

-- Table for admin users
create table admin
(
    user_type         smallint
        constraint admin_user_type_check
            check ((user_type >= 0) AND (user_type <= 2)),
    id                bigserial
        primary key,
    verification_code bigint,
    email             varchar(255),
    full_name         varchar(255),
    password          varchar(255),
    username          varchar(255)
);

-- Table for shopping carts
create table cart
(
    total_amount   double precision,
    total_discount double precision,
    total_price    double precision,
    total_shipping double precision,
    id             bigserial
        primary key,
    user_id        bigint
);

-- Table for customer users
create table customer
(
    user_type    smallint
        constraint customer_user_type_check
            check ((user_type >= 0) AND (user_type <= 2)),
    id           bigserial
        primary key,
    address      varchar(255),
    city         varchar(255),
    country      varchar(255),
    email        varchar(255),
    full_name    varchar(255),
    password     varchar(255),
    phone_number varchar(255),
    state        varchar(255),
    username     varchar(255),
    zip_code     varchar(255)
);

-- Table for orders
create table eorder
(
    total_amount     double precision,
    id               bigserial
        primary key,
    order_date       timestamp(6),
    payment_method   varchar(255),
    shipping_address varchar(255),
    status           varchar(255)
        constraint eorder_status_check
            check ((status)::text = ANY
        ((ARRAY ['PENDING'::character varying, 'PROCESSING'::character varying, 'SHIPPED'::character varying, 'DELIVERED'::character varying, 'CANCELLED'::character varying])::text[]))
    );

-- Table for payments
create table payment
(
    amount         double precision,
    id             bigserial
        primary key,
    order_id       bigint not null
        constraint fk_order_id
            references eorder,
    payment_date   timestamp(6),
    payment_method varchar(255)
        constraint payment_payment_method_check
            check ((payment_method)::text = ANY
        ((ARRAY ['CREDIT_CARD'::character varying, 'DEBIT_CARD'::character varying, 'PAYPAL'::character varying, 'CASH_ON_DELIVERY'::character varying])::text[])),
    payment_status varchar(255)
        constraint payment_payment_status_check
            check ((payment_status)::text = ANY
                   ((ARRAY ['PENDING'::character varying, 'PAID'::character varying, 'CANCELLED'::character varying])::text[]))
);

-- Table for products
create table product
(
    price    double precision not null,
    quantity integer          not null,
    cart_id  bigint
        constraint fk4dk3kwbu3jpiq1xxbmkasv9n3
            references cart,
    id       bigserial
        primary key,
    category varchar(255),
    name     varchar(255)
);

-- Table for order items
create table order_item
(
    price      double precision,
    quantity   integer,
    total      double precision,
    id         bigserial
        primary key,
    order_id   bigint
        constraint fkk8ic1tr86xvlxce25oxjb5f8h
            references eorder,
    product_id bigint
        constraint fk551losx9j75ss5d6bfsqvijna
            references product
);

-- Table for product reviews
create table review
(
    rating      integer,
    customer_id bigint not null
        constraint fkgce54o0p6uugoc2tev4awewly
            references customer,
    id          bigserial
        primary key,
    product_id  bigint
        constraint fkiyof1sindb9qiqr9o8npj8klt
            references product,
    review_date timestamp(6),
    comment     varchar(255),
    title       varchar(255)
);

-- Table for seller users
create table seller
(
    user_type            smallint
        constraint seller_user_type_check
            check ((user_type >= 0) AND (user_type <= 2)),
    id                   bigserial
        primary key,
    company_address      varchar(255),
    company_name         varchar(255),
    company_phone_number varchar(255),
    email                varchar(255),
    full_name            varchar(255),
    password             varchar(255),
    username             varchar(255)
);
