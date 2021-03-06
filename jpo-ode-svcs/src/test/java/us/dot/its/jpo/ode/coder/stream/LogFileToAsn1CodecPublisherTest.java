/*******************************************************************************
 * Copyright 2018 572682
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package us.dot.its.jpo.ode.coder.stream;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;

import org.junit.Test;

import mockit.Capturing;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import us.dot.its.jpo.ode.coder.StringPublisher;
import us.dot.its.jpo.ode.importer.ImporterDirectoryWatcher.ImporterFileType;
import us.dot.its.jpo.ode.importer.parser.FileParser.ParserStatus;
import us.dot.its.jpo.ode.importer.parser.LogFileParser;

public class LogFileToAsn1CodecPublisherTest {

   @Tested
   LogFileToAsn1CodecPublisher testLogFileToAsn1CodecPublisher;

   @Injectable
   StringPublisher injectableStringPublisher;

   @Capturing
   LogFileParser capturingLogFileParser;

   @Mocked
   LogFileParser mockTimLogFileParser;

   @Test
   public void testPublishEOF() throws Exception {
      new Expectations() {
         {
            LogFileParser.factory(anyString);
            result = mockTimLogFileParser;

            mockTimLogFileParser.parseFile((BufferedInputStream) any, anyString);
            result = ParserStatus.EOF;
         }
      };

      testLogFileToAsn1CodecPublisher.publish(new BufferedInputStream(new ByteArrayInputStream(new byte[0])),
            "fileName", ImporterFileType.OBU_LOG_FILE);

   }

}
