package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_68
   extends TilingType
{
   public TilingTypeNC6_68(){
      super( "NC6-68", 6, SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{100,100,180,180};
      paramDef = new int[]{ 50, 65, 80, 40};
      paramName = new String[]{"Aspect", "Relative Length", "Angle 1", "Angle 2"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 5,4, 0,4,5, 0},
            {0, 0,5, 0,5,0, 0},
            {1, 4,1, 1,1,4, 0},
      };
      info = "a=d\nc=e\nA+B+C=360\nC+D=360\n(D+E+F=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.5;
      double w = lntotal * getParam(paramValues, 0)/100;
      double ln12 = lntotal - w;
      double ln1 = ln12 * getParam(paramValues, 1)/100;
      double ln2 = ln12 - ln1;

      double a = getParam(paramValues, 2);
      double b = getParam(paramValues, 3);
      double c1 = ln1 * Math.cos(a * DEG2RAD);
      double s1 = ln1 * Math.sin(a * DEG2RAD);
      double c2 = ln2 * Math.cos(b * DEG2RAD);
      double s2 = ln2 * Math.sin(b * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w-c2, -s2);
      baseTile.setPoint(2,  w, 0);
      baseTile.setPoint(3,  w+c1, s1);
      baseTile.setPoint(4,  w+c1+c2, s1+s2);
      baseTile.setPoint(5,  c1, s1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(1)-tiles[0].getX(2);
      offsets[1] = tiles[2].getY(1)-tiles[0].getY(2);
      offsets[2] = tiles[2].getX(3)-tiles[0].getX(4);
      offsets[3] = tiles[2].getY(3)-tiles[0].getY(4);
   }
}