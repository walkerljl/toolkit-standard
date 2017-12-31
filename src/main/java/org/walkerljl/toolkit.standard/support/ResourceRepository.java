package org.walkerljl.toolkit.standard.support;

import org.walkerljl.toolkit.standard.Resource;
import org.walkerljl.toolkit.standard.exception.machine.MachineException;

import java.util.*;

/**
 * ResourceRepository
 *
 * @author xingxun
 * @Date 2016/12/12
 */
public class ResourceRepository {

    private static final Map<String, Resource> REPOSITROY = new HashMap<String, Resource>();

    public static void register(String groupId, String resourceId, Resource resource) {
        assertParams(groupId, resourceId);
        if (resource == null) {
            throw new MachineException("Resource instance is null.");
        }
        REPOSITROY.put(buildIdentityKey(groupId, resourceId), resource);
    }

    public static void unregister(String groupId, String resourceId) {
        assertParams(groupId, resourceId);
        REPOSITROY.remove(buildIdentityKey(groupId, resourceId));
    }

    private static void assertParams(String groupId, String resourceId) {
        if (groupId == null || "".equals(groupId.trim())) {
            throw new MachineException("Resource group id is blank.");
        }
        if (resourceId == null || "".equals(resourceId.trim())) {
            throw new MachineException("Resource id is blank.");
        }
    }

    public static Resource lookup(String groupId, String resourceId) {
        assertParams(groupId, resourceId);
        return REPOSITROY.get(buildIdentityKey(groupId, resourceId));
    }

    public static Collection<Resource> lookupAll() {
        return Collections.unmodifiableCollection(REPOSITROY.values());
    }

    private static String buildIdentityKey(String groupId, String resourceId) {
        return String.format("%s:%s", groupId, resourceId);
    }
}
