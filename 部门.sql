##各个部门列表
SELECT
    bf1.id as '部门id',
        bf1.paths '路径',


        bf1.dep_name as '部门名称',

        bf2.dep_name as '1父级部门',


        bf3.dep_name as '2父级部门',


        bf4.dep_name as '3父级部门',


        bf5.dep_name as '4父级部门',


        bf6.dep_name as '5父级部门',


        bf7.dep_name as '6父级部门',


        bf8.dep_name as '7父级部门',








        bf1.dep_level as'等级'

FROM
    bf_auth_department  bf1

        LEFT JOIN bf_auth_department  bf2  	ON bf2.id = bf1.parent_id

        left join bf_auth_department bf3  on bf3.id = bf2.parent_id

        left join bf_auth_department bf4  on bf4.id = bf3.parent_id

        left join bf_auth_department bf5  on bf5.id = bf4.parent_id

        left join bf_auth_department bf6  on bf6.id = bf5.parent_id

        left join bf_auth_department bf7  on bf7.id = bf6.parent_id

        left join bf_auth_department bf8  on bf8.id = bf7.parent_id








order by  bf1.dep_level asc;