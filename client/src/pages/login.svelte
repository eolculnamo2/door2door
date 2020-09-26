<script lang="ts">
  import TextField from "smelte/src/components/TextField";
  import axios from "axios";
  import { Link } from "svelte-routing";

  let email;
  let password;

  const handleLogin = async (e) => {
    const response = await axios.post('http://0.0.0.0:8080/login' , {email, password})
    console.log(response.data)
  };
</script>

<style>
  main {
    background-color: rgb(245, 245, 245);
    width: 100vw;
    height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .loginContainer {
    width: 95vw;
    padding: 2em;
    background-color: white;
    border-radius: 3px;

    display: flex;
    flex-direction: column;
  }

  @media (min-width: 1050px) {
    .loginContainer {
      width: 40vw;
    }
  }

  .loginHeader {
    font-size: 2em;
    text-align: center;
  }

  button {
    background-color:#003a8c;
    padding: 0.5em 0;
    color: white;
    font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    font-weight: bold;
  }

  .linksDiv {
    margin-top:0.5em;
    display:flex;
    justify-content: space-evenly;
  }
</style>

<main>
  <span style="font-size:5em; margin:1em;">Logo</span>
  <!-- svelte-ignore a11y-invalid-attribute -->
  <div class="loginContainer">
    <span class="loginHeader">Login</span>
    <TextField bind:value={email} label="email" />
    <TextField bind:value={password} label="password" />
    <button color="primary" on:click={handleLogin}>Login</button>
    <div class="linksDiv">
      <a href="#">Forgot password?</a>
      <Link to="/">Create account</Link>
    </div>
  </div>
</main>
