Requirements
============
- **Sharing Of Code**
   - Regardless of whether you’re using a local or remote Infinispan instance, you should be able to select from a set of data structures which include, but are not limited to: Counter, Map, MultiMap, Lock, Query, Executor.


- **Type of API**

   - Data manipulation APIs
   - Lifecycle APIs
   - Management APIs
   - Monitoring APIs

- **Modularity**
   You’d want to be able to make sure that situations like this are covered: a remote counter user should not need to depend on remote query dependencies.
