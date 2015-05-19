/*
 * Copyright (c) 2015 IBM Corp. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package com.cloudant.http;

/**
 A <code>HttpConnectionResponseFilter</code>/

 A Response Filter is run after the response is obtained from the
 server but before the output stream is returned to the original client. The Response
 Filter enables two main behaviours:

 - Modifying the response for every request

 - Replaying a (potentially modified) request by reacting to the
 response. For example, obtaining a cookie on receipt of a 401
 response code, modifying the "Cookie" header of the original
 request, then setting replayRequest to <code>true</code> to replay the request
 with the new "Cookie" header, see {@link CookieFilter#filterResponse(HttpConnectionFilterContext)}
 for an example of replying requests based on the response code.

 Filters are executed in a pipeline and modify the context in a serial fashion.
 */
public interface HttpConnectionResponseFilter {

    /**
     * Filter the response
     * @param context Input context
     * @return Output context
     */
    HttpConnectionFilterContext filterResponse(HttpConnectionFilterContext context);
}
