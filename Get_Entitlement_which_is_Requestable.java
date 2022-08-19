/**
*
*Rule - Get the Entitlement which is requestable
*
*/
	
	import sailpoint.object.QueryOptions;
	import sailpoint.object.Filter;
	import sailpoint.object.ManagedAttribute;
	import sailpoint.object.Identity;
	import sailpoint.api.ObjectUtil;
	import java.util.*;

	List entitlements = context.getObjects(ManagedAttribute.class);
	log.debug("List of Entitlements: ");

	for (ManagedAttribute ent : entitlements){
		log.debug("getValue(): " +ent.getValue());
	}

	// Entitlements which are requestable
	QueryOptions qo = new QueryOptions();
	qo.addFilter(Filter.eq("requestable", (boolean) true));

	List reqEntitlements = context.getObjects(ManagedAttribute.class, qo);

	log.debug("List of Requestable Entitlements: ");

	for (ManagedAttribute ent : reqEntitlements){
		log.debug("getValue(): " +ent.getValue());
	}

	log.debug("\nTotal No. of Entitlements: "+entitlements.size());
	log.debug("\nTotal No. of Requestable Entitlements: "+reqEntitlements.size());