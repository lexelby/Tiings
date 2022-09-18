package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_04
   extends TilingType
{
   public TilingTypeNC5_04(){
      super( "NC5-4", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,4, 0},
            {0, 3,2, 0,2,3, 0},
            {1, 0,1, 2,0,4, 0},
      };
      info = "a=b=d\nc=e\nB+E=360\nB+2C+D=360\n(A+C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double h = 2. * paramValues[0]/100;
      double ln1 = 2-h;
      h += Math.sqrt(3);
      double ln2 = Math.sqrt(ln1*ln1/4 + h*h);
      double d = 2 * Math.atan2(ln1/2,h)/DEG2RAD;
      double r = 90-3*d/2;
      
      // scale
      double f = ln2*0.618;
      ln1 /=f;
      ln2 /=f;


      double x1 = ln1 * Math.cos( (-r) * DEG2RAD);
      double y1 = ln1 * Math.sin( (-r) * DEG2RAD);
      double x2 = ln2;
      double y2 = 0;
      double x3 = ln2 * Math.cos( (d) * DEG2RAD);
      double y3 = ln2 * Math.sin( (d) * DEG2RAD);
      double x4 = ln1 * Math.cos( (d-r) * DEG2RAD);
      double y4 = ln1 * Math.sin( (d-r) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(1);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(1);
      offsets[2] = tiles[2].getX(0)-tiles[1].getX(4);
      offsets[3] = tiles[2].getY(0)-tiles[1].getY(4);
   }
}
