package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_44
   extends TilingType
{
   public TilingTypeNC6_44(){
      super( "NC6-44", 6, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,360};
      paramDef = new int[]{ 40, 60};
      paramName = new String[]{"Relative Length", "Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 3,2, 0,2,3, 0},
            {1, 5,0, 0,4,5, 1},
            {1, 4,3, 2,3,4, 1},
      };
      info = "a=d=f\nc=e\nC=E\nC+D=360\n2A+F=360\n(B+E=A)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 2.0;
      double ln1 = lntotal * getParam(paramValues, 0)/100;
      double ln2 = lntotal - ln1;
      double f = getParam(paramValues, 1);
      double c = ln1 * Math.cos(f/2 * DEG2RAD);
      double s = ln1 * Math.sin(f/2 * DEG2RAD);
      
      baseTile.setPoint(0,       0,     0);
      baseTile.setPoint(1,     ln2,     0);
      baseTile.setPoint(2, (ln2+c)/2, 3*s/2);
      baseTile.setPoint(3, (ln2-c)/2,   s/2);
      baseTile.setPoint(4,         0,   s+s);
      baseTile.setPoint(5,        -c,     s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(5)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(5)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(0)-tiles[0].getY(0);
   }
}