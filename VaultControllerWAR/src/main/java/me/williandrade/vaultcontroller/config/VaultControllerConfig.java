package me.williandrade.vaultcontroller.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/service")
public class VaultControllerConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();

		classes.add(me.williandrade.vaultcontroller.config.RequestParamFilter.class);
		classes.add(me.williandrade.vaultcontroller.config.ResponseFilter.class);

		classes.add(me.williandrade.vaultcontroller.service.UserService.class);
		classes.add(me.williandrade.vaultcontroller.service.VaultService.class);
		classes.add(me.williandrade.vaultcontroller.service.VaultViewService.class);
		classes.add(me.williandrade.vaultcontroller.service.VaultTransactionService.class);

		return classes;
	}

}