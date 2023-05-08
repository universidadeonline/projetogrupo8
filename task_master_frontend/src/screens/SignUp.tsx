import { Image } from "native-base";

import { ScreenDefault } from "../components/ScreenDefault";
import { FormSignUp } from "../components/FormSignUp";

export function SignUp() {
  return (
    <ScreenDefault>
      <Image source={require("../assets/logo.png")} alt="Logo" />
      <FormSignUp />
    </ScreenDefault>
  );
}
