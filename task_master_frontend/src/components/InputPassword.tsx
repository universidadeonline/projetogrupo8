import React, { useState } from "react";
import {
  FormControl,
  Box,
  Input,
  IInputProps,
  Pressable,
  Icon,
} from "native-base";
import { MaterialIcons } from "@expo/vector-icons";

import { InputDefault, InputDefaultProps } from "./InputDefault";

export function InputPassword({ label = "Senha", ...rest }: InputDefaultProps) {
  const [show, setShow] = useState(false);
  return (
    <InputDefault
      label={label}
      type={show ? "text" : "password"}
      InputRightElement={
        <Pressable onPress={() => setShow(!show)}>
          <Icon
            as={<MaterialIcons name={show ? "visibility" : "visibility-off"} />}
            size={5}
            mr="2"
            color="muted.400"
          />
        </Pressable>
      }
      {...rest}
    />
  );
}
