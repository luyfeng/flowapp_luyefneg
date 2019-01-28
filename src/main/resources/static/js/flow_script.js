$(document).ready(function() {

    $("#submit-put").click(function () {
        var flow_id = $("#flow_id");
        var priority = $("#priority");
        var table_id = $("#table_id");
        var hard_timeout = $("#hard-timeout");
        var idle_timeout = $("#idle-timeout")
        var flow_name = $("#flow-name")
        var in_port = $("#in-port")
        var instruction_order = $("#instruction-order")
        var action_order = $("#action-order")
        var output_node_connector = $("#output-node-connector")

        var data = {
            "flow": [
                {
                    "id": flow_id.val().trim(),
                    "priority": priority.val().trim(),
                    "table_id": table_id.val().trim(),
                    "hard-timeout": hard_timeout.val().trim(),
                    "idle-timeout": idle_timeout.val().trim(),
                    "flow-name": flow_name.val().trim(),
                    "match": {
                        "in-port": in_port.val().trim()
                    },
                    "instructions": {
                        "instruction": [
                            {
                                "order": instruction_order.val().trim(),
                                "apply-actions": {
                                    "action": [
                                        {
                                            "order": action_order.val().trim(),
                                            "output-action": {
                                                "output-node-connector": output_node_connector.val().trim()
                                            }
                                        }
                                    ]
                                }
                            }
                        ]
                    }
                }
            ]

        };

        // $.ajax({
        //     url: "http://10.1.11.26:8181/restconf/config/opendaylight-inventory:nodes/node/openflow:1/flow-node-inventory:table/0/flow/"+id.val().trim(),
        //     type: "put",
        //     async: "true",
        //     contentType: 'application/json; charset=utf-8',
        //     dataType: "json",
        //     data: JSON.stringify(data),
        //     beforeSend: function(xhr){
        //         xhr.setRequestHeader("Authorization",
        //             //"Basic " + encodeBase64(username + ":" + password));
        //             "Basic YWRtaW46YWRtaW4=");
        //     },
        //     success: function(data) {
        //         alert("addflow success!")
        //     },
        //     error: function() {
        //         alert("addflow fail!")
        //     }
        // });
    });


})