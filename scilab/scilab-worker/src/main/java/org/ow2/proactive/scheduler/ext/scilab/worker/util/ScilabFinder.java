/*
 * ################################################################
 *
 * ProActive Parallel Suite(TM): The Java(TM) library for
 *    Parallel, Distributed, Multi-Core Computing for
 *    Enterprise Grids & Clouds 
 *
 * Copyright (C) 1997-2010 INRIA/University of 
 * 				Nice-Sophia Antipolis/ActiveEon
 * Contact: proactive@ow2.org or contact@activeeon.com
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; version 3 of
 * the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
 * USA
 *
 * If needed, contact us to obtain a release under GPL Version 2 
 * or a different license than the GPL.
 *
 *  Initial developer(s):               The ProActive Team
 *                        http://proactive.inria.fr/team_members.htm
 *  Contributor(s): ActiveEon Team - http://www.activeeon.com
 *
 * ################################################################
 * $$ACTIVEEON_CONTRIBUTOR$$
 */
package org.ow2.proactive.scheduler.ext.scilab.worker.util;

import java.util.HashSet;

import org.apache.log4j.Level;
import org.ow2.proactive.scheduler.ext.matsci.worker.util.MatSciEngineConfig;
import org.ow2.proactive.scheduler.ext.matsci.worker.util.MatSciFinder;


public class ScilabFinder extends MatSciFinder {

    public ScilabFinder (boolean isDebug) {

        // Set the log4j level according to the config
        if (isDebug)
            logger.setLevel(Level.DEBUG);
    }

    /**
     * Utility function to find Matlab
     */
    public MatSciEngineConfig findMatSci(String version_pref, String versionsRej, String versionMin,
            String versionMax, String versionArch, boolean debug) throws Exception {
        return findMatSci(version_pref, parseVersionRej(versionsRej), versionMin, versionMax, versionArch,
                debug);
    }

    public MatSciEngineConfig findMatSci(String version_pref, HashSet<String> versionsRej, String versionMin,
            String versionMax, String versionArch, boolean debug) throws Exception {

        HashSet<MatSciEngineConfig> confs = new ScilabConfigurationParser(debug).getConfigs();
        if (confs == null)
            return null;

        MatSciEngineConfig answer = chooseMatSciConfig(confs, version_pref, versionsRej, versionMin,
                versionMax, versionArch);

        return answer;
    }

}
