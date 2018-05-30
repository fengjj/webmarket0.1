select * from dc_cen.v_cen_index_all;

select * from dc_cen.v_meta_detail;

select * from dc_cen.dic_dim_meta_def;

select * from dc_cen.dic_dim_meta_valuedef;

select dim_code, dim_code_name, sys_connect_by_path(dim_code_name,'->'), connect_by_isleaf 
from (
select *
from dc_cen.dic_dim_meta_valuedef
where dim_id='20012'  )
connect by prior dim_code=parent_dim_code
start with parent_dim_code is null

