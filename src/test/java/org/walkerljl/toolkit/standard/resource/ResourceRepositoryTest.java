package org.walkerljl.toolkit.standard.resource;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.walkerljl.toolkit.standard.machine.exception.MachineException;
import org.walkerljl.toolkit.standard.resource.abstracts.AbstractResource;
import org.walkerljl.toolkit.standard.resource.exception.CannotDestroyResourceException;
import org.walkerljl.toolkit.standard.resource.exception.CannotInitResourceException;

import java.util.Collection;

/**
 * ResourceRepositoryTest
 *
 * @author xingxun
 * @Date 2018/5/19
 */
public class ResourceRepositoryTest {

    @Test
    public void test() {

        String groupId = "groupId";
        String resourceId = "resourceId";

        boolean actualFlag = false;
        try {
            ResourceRepository.lookup(null, resourceId);
        } catch (MachineException e) {
            actualFlag = true;
        }
        Assert.assertTrue(actualFlag);
        actualFlag = false;

        try {
            ResourceRepository.lookup(groupId, null);
        } catch (MachineException e) {
            actualFlag = true;
        }
        Assert.assertTrue(actualFlag);
        actualFlag = false;

        Resource actual = ResourceRepository.lookup(groupId, resourceId);
        Assert.assertNull(actual);

        Resource expected = new AbstractResource() {
            @Override
            public void processInit() throws CannotInitResourceException {

            }

            @Override
            public void processDestroy() throws CannotDestroyResourceException {

            }

            @Override
            public String getId() {
                return resourceId;
            }

            @Override
            public String getGroup() {
                return groupId;
            }
        };
        ResourceRepository.register(expected.getGroup(), expected.getId(), expected);
        actual = ResourceRepository.lookup(groupId, resourceId);
        Assert.assertEquals(actual, expected);

        Collection<Resource> allResources = ResourceRepository.lookupAll();
        Assert.assertEquals(allResources.size(), 1);
        Assert.assertEquals(allResources.iterator().next(), expected);
        try {
            allResources.add(expected);
        } catch (UnsupportedOperationException e) {
            actualFlag = true;
        }
        Assert.assertTrue(actualFlag);

        ResourceRepository.unregister(expected.getGroup(), expected.getId());
        actual = ResourceRepository.lookup(groupId, resourceId);
        Assert.assertNull(actual);
    }
}
