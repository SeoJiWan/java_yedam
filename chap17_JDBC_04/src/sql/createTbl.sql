create table products (product_id number primary key,
                       product_name varchar2(100) not null,
                       product_price number not null,
                       product_stock number default 0);
              
create sequence products_seq 
                start with 1
                increment by 1
                minvalue 1
                maxvalue 9999
                nocache
                nocycle
                noorder;
                       
desc products;                       

create table receiving_goods (
    deal_date Date default sysdate,
    product_id number constraint rec_pid_fk references products (product_id),
    product_amount number);
    
desc receiving_goods;

create table export_goods (
    deal_date Date default sysdate,
    product_id number constraint ex_pid_fk references products (product_id),
    product_amount number);
    
desc export_goods;    
    
                              
                       