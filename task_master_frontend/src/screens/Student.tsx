import { Heading } from "native-base";

import { ScreenDefault } from "../components/ScreenDefault";
import { Menu } from "../components/Menu";

export function Student() {
  return (
    <ScreenDefault header="Aluno" student>
      <Menu type="float" />
    </ScreenDefault>
  );
}
