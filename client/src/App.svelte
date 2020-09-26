<script lang="ts">
  import "smelte/src/tailwind.css";
  import { Router, Route, Link } from "svelte-routing";
import Login from "./pages/login.svelte";

  let url = "";
</script>

<style>
</style>

<main>
  <Router url="{url}">
      <Route path="/" component="{Login}" />
  </Router>
</main>
