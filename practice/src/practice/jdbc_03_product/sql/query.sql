create table products (product_id number(10) primary key,
                        product_name varchar2(100) constraint pro_name_nn not null,
                        product_price number(15) constraint pro_price_nn not null);
                        
create sequence pro_seq
                increment by 1
                start with 1
                nocache
                nocycle;                     
                        
create table products_history (product_id number(10) constraint ph_id_fk references products (product_id),
                             product_category char(2) constraint pro_cg_ch check (product_category in ('IN', 'EX')),
                             product_amount number(10));
                        