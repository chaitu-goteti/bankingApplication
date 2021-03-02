package com.temporal.bankingApp.workers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temporal.bankingApp.service.TransferActivityService;
import com.temporal.constants.Shared;
import com.temporal.service.MoneyTransferWorkflowImpl;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

@Service
public class MoneyTransferWorker {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MoneyTransferWorker.class);
	
	@Autowired
	TransferActivityService transferActivityService;
	
	public void approveTransactions() {
		// WorkflowServiceStubs is a gRPC stubs wrapper that talks to the local Docker instance of the Temporal server.
        WorkflowServiceStubs service = WorkflowServiceStubs.newInstance();
        WorkflowClient client = WorkflowClient.newInstance(service);
        // Worker factory is used to create Workers that poll specific Task Queues.
        WorkerFactory factory = WorkerFactory.newInstance(client);
        Worker worker = factory.newWorker(Shared.MONEY_TRANSFER_TASK_QUEUE);
        // This Worker hosts both Workflow and Activity implementations.
        // Workflows are stateful so a type is needed to create instances.
        worker.registerWorkflowImplementationTypes(MoneyTransferWorkflowImpl.class);
        // Activities are stateless and thread safe so a shared instance is used.
        worker.registerActivitiesImplementations(transferActivityService);
        // Start listening to the Task Queue.
        factory.start();
        //factory.shutdown();
	}
}
