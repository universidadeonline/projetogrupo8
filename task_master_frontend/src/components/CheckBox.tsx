import { Checkbox, Text, ICheckboxProps } from "native-base";

interface CheckBoxProps extends ICheckboxProps {
  label?: string;
}

export function CheckBox({ label, value, ...rest }: CheckBoxProps) {
  return (
    <Checkbox value={value} colorScheme="purple" {...rest}>
      {label && <Text bold fontSize={"md"}>{label}</Text>}
    </Checkbox>
  );
}
