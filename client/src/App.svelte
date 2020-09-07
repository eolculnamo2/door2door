<script lang="ts">
  interface LoginPayload {
    email: String;
    password: String;
  }
  const validateLogin = async (payload:LoginPayload) => {
    const response = await axios.post('/login' , payload)
    if (response.status === 200) {
      // set Context and redirect to dashboard
    }
  }
</script>

<style>
  main {
    margin: 0;
    width: 100vw;
    height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  .formContainer {
    padding: 1em;
    width: 900px;
    height: 200px;
    background-color: whitesmoke;
    border-radius: 2px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-self: center;
  }
  .loginInput {
    width: 100%;
    line-height: 22px;
  }
  .loginButton {
    width: 100%;
    background-color: blue;
    height: 2em;
    color: white;
  }

  .loginButton:active {
    background-color: lightblue;
  }
</style>

<main>
  <h1>Door2Door</h1>
  <div class="formContainer">
    <h2>Login</h2>
    <input type="text" class="loginInput" />
    <input type="text" class="loginInput" />
    <button class="loginButton">Login</button>
  </div>
</main>
