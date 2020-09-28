/*
 * Copyright (c) 2020 PANTHEON.tech s.r.o. All Rights Reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at https://www.eclipse.org/legal/epl-v10.html
 */
package io.lighty.netconf.device.topology.processors;

import java.util.concurrent.ExecutionException;
import org.opendaylight.yang.gen.v1.urn.tech.pantheon.netconfdevice.network.topology.rpcs.rev180320.GetNodeFromTopologyByIdInput;
import org.opendaylight.yang.gen.v1.urn.tech.pantheon.netconfdevice.network.topology.rpcs.rev180320.GetNodeFromTopologyByIdOutput;
import org.opendaylight.yang.gen.v1.urn.tech.pantheon.netconfdevice.network.topology.rpcs.rev180320.NetworkTopologyRpcsService;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("checkstyle:MemberName")
public class NetworkTopologyServiceGetNodeFromTopologyProcessor extends
    NetworkTopologyServiceAbstractProcessor<GetNodeFromTopologyByIdInput, GetNodeFromTopologyByIdOutput> {

    private static final Logger LOG = LoggerFactory.getLogger(NetworkTopologyServiceGetNodeFromTopologyProcessor.class);

    private final NetworkTopologyRpcsService networkTopologyRpcsService;
    private final QName qName = QName.create("urn:tech.pantheon.netconfdevice.network.topology.rpcs",
        "get-node-from-topology-by-id");

    public NetworkTopologyServiceGetNodeFromTopologyProcessor(NetworkTopologyRpcsService networkTopologyRpcsService) {
        this.networkTopologyRpcsService = networkTopologyRpcsService;
    }

    @Override
    public QName getIdentifier() {
        return qName;
    }


    @Override
    protected RpcResult<GetNodeFromTopologyByIdOutput> execMethod(final GetNodeFromTopologyByIdInput input)
            throws ExecutionException, InterruptedException {
        final RpcResult<GetNodeFromTopologyByIdOutput> voidRpcResult = networkTopologyRpcsService
                .getNodeFromTopologyById(input).get();
        return voidRpcResult;
    }
}