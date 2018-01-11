/**
 * 单表数据
 */ 
var singleTable=[
                        {
                            "remarks": "字段主键",
                            "createDate": 1496040983000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "id",
                            "typeName": "varchar",
                            "columnSize": "32",
                            "parmaryKey": true,
                            "importedKey": false,
                            "nullable": false,
                            "decimalDigits": "0",
                            "javaType": "String",
                            "javaField": "id",
                            "isList": false,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": false,
                            "formType": "input",
                            "hibernateType": "java.lang.String"
                        },{
                            "remarks": "创建者",
                            "createDate": 1496040983000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "create_by",
                            "typeName": "varchar",
                            "columnSize": "32",
                            "parmaryKey": false,
                            "importedKey": false,
                            "nullable": true,
                            "decimalDigits": "0",
                            "javaType": "User",
                            "javaField": "createBy",
                            "isList": false,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": false,
                            "formType": "input",
                            "hibernateType": "java.lang.String"
                        },{
                            "remarks": "创建时间",
                            "createDate": 1496040983000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "create_date",
                            "typeName": "datetime",
                            "columnSize": "19",
                            "parmaryKey": false,
                            "importedKey": false,
                            "nullable": true,
                            "decimalDigits": "0",
                            "javaType": "Date",
                            "javaField": "createDate",
                            "isList": false,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": false,
                            "formType": "input",
                            "hibernateType": "java.util.Date"
                        },{
                            "remarks": "更新者",
                            "createDate": 1496040983000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "update_by",
                            "typeName": "varchar",
                            "columnSize": "32",
                            "parmaryKey": false,
                            "importedKey": false,
                            "nullable": true,
                            "decimalDigits": "0",
                            "javaType": "User",
                            "javaField": "updateBy",
                            "isList": false,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": false,
                            "formType": "input",
                            "hibernateType": "java.lang.String",
                            "new": false
                        },
                        {
                            "remarks": "更新时间",
                            "createDate": 1496040983000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "update_date",
                            "typeName": "datetime",
                            "columnSize": "19",
                            "parmaryKey": false,
                            "importedKey": false,
                            "nullable": true,
                            "decimalDigits": "0",
                            "javaType": "Date",
                            "javaField": "updateDate",
                            "isList": false,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": false,
                            "formType": "input",
                            "hibernateType": "java.util.Date"
                        },
                        {
                            "remarks": "删除标记（0：正常；1：删除）",
                            "createDate": 1496040983000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "del_flag",
                            "typeName": "char",
                            "columnSize": "1",
                            "parmaryKey": false,
                            "importedKey": false,
                            "nullable": false,
                            "columnDef": "0",
                            "decimalDigits": "0",
                            "javaType": "String",
                            "javaField": "delFlag",
                            "isList": false,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": false,
                            "formType": "input",
                            "hibernateType": "java.lang.String"
                        },
                        {
                            "remarks": "备注信息",
                            "createDate": 1496040983000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "remarks",
                            "typeName": "varchar",
                            "columnSize": "255",
                            "parmaryKey": false,
                            "importedKey": false,
                            "nullable": true,
                            "decimalDigits": "0",
                            "javaType": "String",
                            "javaField": "remarks",
                            "isList": false,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": true,
                            "formType": "input",
                            "hibernateType": "java.lang.String"
                        }
                    ];

/**
 * 树形数据
 */ 
var treeTable=[
                        {
                            "remarks": "字段主键",
                            "createDate": 1496040983000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "id",
                            "typeName": "varchar",
                            "columnSize": "32",
                            "parmaryKey": true,
                            "importedKey": false,
                            "nullable": false,
                            "decimalDigits": "0",
                            "javaType": "String",
                            "javaField": "id",
                            "isList": false,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": false,
                            "formType": "input",
                            "hibernateType": "java.lang.String"
                        },{
                            "remarks": "机构名称",
                            "createDate": 1496041814000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "name",
                            "typeName": "varchar",
                            "columnSize": "100",
                            "parmaryKey": false,
                            "importedKey": false,
                            "nullable": true,
                            "decimalDigits": "0",
                            "javaType": "String",
                            "javaField": "name",
                            "isList": false,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": false,
                            "formType": "input",
                            "hibernateType": "java.lang.String"
                        },
                        {
                            "remarks": "父节点",
                            "createDate": 1496041814000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "parent_id",
                            "typeName": "varchar",
                            "columnSize": "32",
                            "parmaryKey": false,
                            "importedKey": false,
                            "nullable": true,
                            "decimalDigits": "0",
                            "javaType": "String",
                            "javaField": "parentId",
                            "isList": false,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": false,
                            "formType": "input",
                            "hibernateType": "java.lang.String"
                        },
                        {
                            "remarks": "父节点路径",
                            "createDate": 1496041814000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "parent_ids",
                            "typeName": "varchar",
                            "columnSize": "1000",
                            "parmaryKey": false,
                            "importedKey": false,
                            "nullable": true,
                            "decimalDigits": "0",
                            "javaType": "String",
                            "javaField": "parentIds",
                            "isList": false,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": false,
                            "formType": "input",
                            "hibernateType": "java.lang.String"
                        },{
                            "remarks": "创建者",
                            "createDate": 1496040983000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "create_by",
                            "typeName": "varchar",
                            "columnSize": "32",
                            "parmaryKey": false,
                            "importedKey": false,
                            "nullable": true,
                            "decimalDigits": "0",
                            "javaType": "String",
                            "javaField": "createBy",
                            "isList": false,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": false,
                            "formType": "input",
                            "hibernateType": "java.lang.String"
                        },{
                            "remarks": "创建时间",
                            "createDate": 1496040983000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "create_date",
                            "typeName": "datetime",
                            "columnSize": "19",
                            "parmaryKey": false,
                            "importedKey": false,
                            "nullable": true,
                            "decimalDigits": "0",
                            "javaType": "Date",
                            "javaField": "createDate",
                            "isList": false,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": false,
                            "formType": "input",
                            "hibernateType": "java.util.Date"
                        },{
                            "remarks": "更新者",
                            "createDate": 1496040983000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "update_by",
                            "typeName": "varchar",
                            "columnSize": "32",
                            "parmaryKey": false,
                            "importedKey": false,
                            "nullable": true,
                            "decimalDigits": "0",
                            "javaType": "String",
                            "javaField": "updateBy",
                            "isList": false,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": false,
                            "formType": "input",
                            "hibernateType": "java.lang.String",
                            "new": false
                        },
                        {
                            "remarks": "更新时间",
                            "createDate": 1496040983000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "update_date",
                            "typeName": "datetime",
                            "columnSize": "19",
                            "parmaryKey": false,
                            "importedKey": false,
                            "nullable": true,
                            "decimalDigits": "0",
                            "javaType": "Date",
                            "javaField": "updateDate",
                            "isList": false,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": false,
                            "formType": "input",
                            "hibernateType": "java.util.Date"
                        },
                        {
                            "remarks": "删除标记（0：正常；1：删除）",
                            "createDate": 1496040983000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "del_flag",
                            "typeName": "char",
                            "columnSize": "1",
                            "parmaryKey": false,
                            "importedKey": false,
                            "nullable": false,
                            "columnDef": "0",
                            "decimalDigits": "0",
                            "javaType": "String",
                            "javaField": "delFlag",
                            "isList": false,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": false,
                            "formType": "input",
                            "hibernateType": "java.lang.String"
                        },
                        {
                            "remarks": "备注信息",
                            "createDate": 1496040983000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "remarks",
                            "typeName": "varchar",
                            "columnSize": "255",
                            "parmaryKey": false,
                            "importedKey": false,
                            "nullable": true,
                            "decimalDigits": "0",
                            "javaType": "String",
                            "javaField": "remarks",
                            "isList": false,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": true,
                            "formType": "input",
                            "hibernateType": "java.lang.String"
                        }
                    ];

/**
 * 树形数据扩展
 */ 
var treeTableExtent=[
                        {
                            "remarks": "机构名称",
                            "createDate": 1496041814000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "name",
                            "typeName": "varchar",
                            "columnSize": "100",
                            "parmaryKey": false,
                            "importedKey": false,
                            "nullable": true,
                            "decimalDigits": "0",
                            "javaType": "String",
                            "javaField": "name",
                            "isList": true,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": true,
                            "formType": "input",
                            "hibernateType": "java.lang.String"
                        },
                        {
                            "remarks": "父节点",
                            "createDate": 1496041814000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "parent_id",
                            "typeName": "varchar",
                            "columnSize": "32",
                            "parmaryKey": false,
                            "importedKey": false,
                            "nullable": true,
                            "decimalDigits": "0",
                            "javaType": "String",
                            "javaField": "parentId",
                            "isList": true,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": true,
                            "formType": "input",
                            "hibernateType": "java.lang.String"
                        },
                        {
                            "remarks": "父节点路径",
                            "createDate": 1496041814000,
                            "delFlag": false,
                            "id": "templateid",
                            "columnName": "parent_ids",
                            "typeName": "varchar",
                            "columnSize": "1000",
                            "parmaryKey": false,
                            "importedKey": false,
                            "nullable": true,
                            "decimalDigits": "0",
                            "javaType": "String",
                            "javaField": "parentIds",
                            "isList": false,
                            "isQuery": false,
                            "queryType": "eq",
                            "isForm": false,
                            "formType": "input",
                            "hibernateType": "java.lang.String"
                        }
                    ];