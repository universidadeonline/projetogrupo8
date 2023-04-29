import { FormControl, Box, Input, IInputProps, Text } from "native-base";

export interface InputDefaultProps extends IInputProps {
  label: string;
  errorMessage?: string | null;
}

export function InputDefault({
  label,
  errorMessage = null,
  isInvalid,
  ...rest
}: InputDefaultProps) {
  const invalid = !!errorMessage || isInvalid;

  return (
    <FormControl isInvalid={invalid}>
      <FormControl.Label>
        <Text color={"purple.900"} fontSize={"md"} fontWeight={"bold"}>
          {label}
        </Text>
      </FormControl.Label>
      <Input
        isInvalid={invalid}
        type={"text"}
        borderRadius={12}
        backgroundColor={"white"}
        color={"#00004D"}
        fontSize={"md"}
        borderWidth={2}
        w={"100%"}
        _focus={{
          borderWidth: 2,
          borderColor: "purple.900",
        }}
        _invalid={{
          mb: 2,
        }}
        {...rest}
      />
      <FormControl.ErrorMessage>
        <Text fontSize={"md"}>{errorMessage}</Text>
      </FormControl.ErrorMessage>
    </FormControl>
  );
}
